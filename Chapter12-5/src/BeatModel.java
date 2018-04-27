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
	Sequencer sequencer;//���� �Ҹ��� ������ ���� ���̴� ������ ��ü
	
	//�� ArrayList�� ���� �ٸ� ������ ���������� �����
	ArrayList<BeatObserver> beatObservers = new ArrayList<BeatObserver>();
	ArrayList<BPMObserver> bpmObservers = new ArrayList<BPMObserver>();
	
	int bpm = 90;//bpm �ν��Ͻ� �������� �д� ��Ʈ���� �����. �⺻���� 90.
	Sequence sequence;
	Track track;
	
	@Override
	public void initialize() {
		//�������� �����ϰ� ��ƮƮ���� ������ִ� �޼ҵ�
		setUpMidi();
		buildTrackAndStart();
	}

	@Override
	public void on() {
		//�������� ���۽�Ű�� BPM�� �⺻���� 90���� ����
		sequencer.start();
		setBPM(90);
	}

	@Override
	public void off() {
		//BPM�� 0���� �����ϰ� �������� ����
		setBPM(0);
		sequencer.stop();
	}

	@Override
	public void setBPM(int bpm) {
		//��Ʈ�ѷ����� setBPM�� ȣ���Ͽ� ��Ʈ���� ������ �� ����
		this.bpm = bpm;//bpm �ν��Ͻ� ���� �� ����
		sequencer.setTempoInBPM(getBPM());//�������� BPM ���� ��û
		notifyBPMObservers();//��� BPM �������� BPM�� �ٲ���ٰ� �˸�
	}

	@Override
	public int getBPM() {
		//���� �д� ��Ʈ���� ��Ÿ���� bpm �ν��Ͻ� ������ ���� ����
		return bpm;
	}
	
	public void beatEvent() {
		//BeatModelInterface���� ����. ��Ʈ�� ���� ���۵� ������ �̵� �ڵ忡�� �� �޼ҵ带 ȣ��.
		//��� BeatObserver��ü�鿡�� ��� �� ���ڰ� �����ٴ� ���� �˷��ֱ� ���� �޼ҵ�.
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
