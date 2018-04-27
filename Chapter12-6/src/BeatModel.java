import java.util.ArrayList;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class BeatModel implements BeatModelInterface, MetaEventListener {
	Sequencer sequencer;//실제 소리를 만들어내기 위해 쓰이는 시퀀서 객체
	
	//두 ArrayList에 서로 다른 종류의 옵저버들이 저장됨
	ArrayList<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
	ArrayList<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
	
	int bpm = 90;//bpm 인스턴스 변수에는 분당 비트수가 저장됨. 기본값은 90.
	Sequence sequence;
	Track track;
	
	@Override
	public void initialize() {
		//시퀀서를 설정하고 비트트랙을 만들어주는 메소드
		setUpMidi();
		buildTrackAndStart();
	}

	@Override
	public void on() {
		//시퀀서를 시작시키고 BPM을 기본값인 90으로 설정
		sequencer.start();
		setBPM(90);
	}

	@Override
	public void off() {
		//BPM을 0으로 설정하고 시퀀서를 종료
		setBPM(0);
		sequencer.stop();
	}

	@Override
	public void setBPM(int bpm) {
		//컨트롤러에서 setBPM을 호출하여 비트수를 조절할 수 있음
		this.bpm = bpm;//bpm 인스턴스 변수 값 설정
		sequencer.setTempoInBPM(getBPM());//시퀀서에 BPM 변경 요청
		notifyBPMObservers();//모든 BPM 옵저버에 BPM이 바뀌었다고 알림
	}

	@Override
	public int getBPM() {
		//현재 분당 비트수를 나타내는 bpm 인스턴스 변수의 값을 리턴
		return bpm;
	}
	
	public void beatEvent() {
		//BeatModelInterface에는 없음. 비트가 새로 시작될 때마다 미디 코드에서 이 메소드를 호출.
		//모든 BeatObserver객체들에게 방금 한 박자가 나갔다는 것을 알려주기 위한 메소드.
		notifyBeatObservers();
	}

	@Override
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}
	
	public void notifyBeatObservers() {
		for (int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver) beatObservers.get(i);
			observer.updateBeat();
		}
	}

	@Override
	public void removeObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}

	@Override
	public void registerObserver(BPMObserver o) {
		bpmObservers.add(o);
	}
	
	public void notifyBPMObservers() {
		for (int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver) bpmObservers.get(i);
			observer.updateBPM();
		}
	}

	@Override
	public void removeObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}

	@Override
	public void meta(MetaMessage message) {
		if (message.getType() == 47) {
			beatEvent();
			sequencer.start();
			setBPM(getBPM());
		}
	}
	
	public void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			sequence = new Sequence(Sequence.PPQ,4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(getBPM());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buildTrackAndStart() {
		int[] trackList = {35, 0, 46, 0};
		
		sequence.deleteTrack(null);
		track = sequence.createTrack();
		
		makeTracks(trackList);
		track.add(makeEvent(192,9,1,0,4));
		try {
			sequencer.setSequence(sequence);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void makeTracks(int[] list) {
		for (int i = 0; i < list.length; i++) {
			int key = list[i];
			
			if (key != 0) {
				track.add(makeEvent(144,9,key,100,i));
				track.add(makeEvent(128,9,key,100,i+1));
			}
		}
	}
	
	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return event;
	}
}
