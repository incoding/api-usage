package com.javaapi.test.testUtil.net.ftp;

//FTP Server

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * not work
 * 
 * @author hncw
 * 
 */
@Deprecated
public class FTPServer {
	public static void main(String args[]) throws Exception {
		ServerSocket soc = new ServerSocket(5217);
		System.out.println("FTP Server Started on Port Number 5217");
		while (true) {
			System.out.println("Waiting for Connection ...");
			transferfile t = new transferfile(soc.accept());

		}
	}
}

class transferfile extends Thread {
	Socket ClientSoc;

	DataInputStream in;
	DataOutputStream out;

	transferfile(Socket soc) {
		try {
			ClientSoc = soc;
			in = new DataInputStream(ClientSoc.getInputStream());
			out = new DataOutputStream(ClientSoc.getOutputStream());
			System.out.println("FTP Client Connected ...");
			start();

		} catch (Exception ex) {
		}
	}

	void SendFile() throws Exception {
		String filename = in.readUTF();
		File f = new File(filename);
		if (!f.exists()) {
			out.writeUTF("File Not Found");
			return;
		} else {
			out.writeUTF("READY");
			FileInputStream fin = new FileInputStream(f);
			int ch;
			do {
				ch = fin.read();
				out.writeUTF(String.valueOf(ch));
			} while (ch != -1);
			fin.close();
			out.writeUTF("File Receive Successfully");
		}
	}

	void ReceiveFile() throws Exception {
		String filename = in.readUTF();
		if (filename.compareTo("File not found") == 0) {
			return;
		}
		File f = new File(filename);
		String option;

		if (f.exists()) {
			out.writeUTF("File Already Exists");
			option = in.readUTF();
		} else {
			out.writeUTF("SendFile");
			option = "Y";
		}

		if (option.compareTo("Y") == 0) {
			FileOutputStream fout = new FileOutputStream(f);
			int ch;
			String temp;
			do {
				temp = in.readUTF();
				ch = Integer.parseInt(temp);
				if (ch != -1) {
					fout.write(ch);
				}
			} while (ch != -1);
			fout.close();
			out.writeUTF("File Send Successfully");
		} else {
			return;
		}

	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for Command ...");
				String Command = in.readUTF();
				if (Command.compareTo("GET") == 0) {
					System.out.println("\tGET Command Received ...");
					SendFile();
					continue;
				} else if (Command.compareTo("SEND") == 0) {
					System.out.println("\tSEND Command Receiced ...");
					ReceiveFile();
					continue;
				} else if (Command.compareTo("DISCONNECT") == 0) {
					System.out.println("\tDisconnect Command Received ...");
					System.exit(1);
				}
			} catch (Exception ex) {
			}
		}
	}
}