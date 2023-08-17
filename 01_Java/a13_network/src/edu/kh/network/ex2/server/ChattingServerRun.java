package edu.kh.network.ex2.server;

import edu.kh.network.ex1.server.Server;

public class ChattingServerRun {
	public static void main(String[] args) {
		ChattingServer chattingServer = new ChattingServer();
		chattingServer.start();
	}
}
