package task1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConnectionInfo connectionInfo1 = new ConnectionInfo(1500, 90);
        ConnectionInfo connectionInfo2 = new ConnectionInfo(1500, 60);
        ConnectionInfo connectionInfo3 = new ConnectionInfo(300, 85);
        ConnectionInfo connectionInfo4 = new ConnectionInfo(2000, 10);
        ConnectionInfo connectionInfo5 = new ConnectionInfo(500, 20);
        ConnectionInfo connectionInfo6 = new ConnectionInfo(900, 5);
        ConnectionInfo connectionInfo7 = new ConnectionInfo(2500, 1);
        ConnectionInfo connectionInfo8 = new ConnectionInfo(1000, 50);
//        1
//        a=0 b=1 c=2 d=3 e=4 f=5
        ConnectionInfo[][] answer1 = new ConnectionInfo[6][6];
        answer1[0][1] = connectionInfo1;
        answer1[1][0] = connectionInfo1;

        answer1[0][2] = connectionInfo4;
        answer1[2][0] = connectionInfo5;

        answer1[0][3] = connectionInfo8;
        answer1[3][0] = connectionInfo6;

        answer1[1][5] = connectionInfo2;
        answer1[5][1] = connectionInfo2;

        answer1[2][4] = connectionInfo6;
        answer1[4][2] = connectionInfo6;
        answer1[2][5] = connectionInfo5;
        answer1[5][2] = connectionInfo5;

        answer1[3][4] = connectionInfo7;
        answer1[4][3] = connectionInfo7;

        answer1[4][5] = connectionInfo3;
        answer1[5][4] = connectionInfo3;

//        2
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");


        Node.connect(a, b,  connectionInfo1);
        Node.connect(a, c,  connectionInfo4);
        Node.connect(a, d,  connectionInfo8);

        Node.connect(b, f,  connectionInfo2);

        Node.connect(c, f,  connectionInfo5);
        Node.connect(c, e,  connectionInfo6);

        Node.connect(d, e,  connectionInfo7);

        Node.connect(e, f,  connectionInfo3);

        List<Node> answer2 = List.of(a, b, c, d, e, f);
    }
}
@Data
class Node {
    private String name;
    List<NodeInfo> nodeConnections = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }

    public static void connect(Node node1, Node node2, ConnectionInfo info) {
        node1.getNodeConnections().add(new NodeInfo(node1, node2, info));
        node2.getNodeConnections().add(new NodeInfo(node2, node1, info));
    }
}

@Data
@AllArgsConstructor
class NodeInfo {
    private Node node1;
    private Node node2;
    private ConnectionInfo connection;
}

@Data
@AllArgsConstructor
class ConnectionInfo {
    private int throughput;
    private int packetLossPercentage;
}
