import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.stream.Collectors;

class Packet {
	private int seqNum;
	private byte[] data;

	public Packet(int seqNum, byte[] data) {
		this.seqNum = seqNum;
		this.data = data;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public String toString() {
		return "[" + this.seqNum + "] = " + new String(this.data, StandardCharsets.UTF_8);
	}

	public boolean equals(Object obj) {
		if (obj instanceof Packet) {
			Packet p = (Packet)obj;
			if (this.seqNum == p.getSeqNum()) {
				return true;
			}
		}
		return false;
	}
}

class PacketBuffer {
	Packet packet;
	final List<Packet> packets = new ArrayList<>();

	public void setPacket(Packet packet) {
		this.packet = packet;
		packets.add(packet);
	}

	public Packet getPacket() {
		return packet;
	}

	public List<Packet> getPackets() {
		return packets;
	}
	
}

class Application {
	public static void main(String[] args) {
		List<Packet> packets = List.of(new Packet(1, "raghu".getBytes()), new Packet(2, "priya".getBytes()), 
			new Packet(1, "raghu".getBytes()), new Packet(2, "priya".getBytes()));

		PacketBuffer pBuffer = new PacketBuffer();
		//write to buffer
		for (Packet p : packets) {
			pBuffer.setPacket(p);
		}

		// read from buffer
		List<Packet> packetsFromBuffer = pBuffer.getPackets();
		Collections.sort(packetsFromBuffer, new Comparator<Packet>() {
			public int compare(Packet p1, Packet p2) {
				return p1.getSeqNum() < p2.getSeqNum() ? 1 : 0;
			}
		});
		Set<Packet> setOfPacks = packetsFromBuffer.stream().collect(Collectors.toSet());

		for (Packet p : setOfPacks) {
			System.out.println(p.toString());
		}

	}
}