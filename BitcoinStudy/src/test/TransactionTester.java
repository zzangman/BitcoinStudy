//package test;
//
//import transaction.TokenTrasaction;
//import transaction.Transaction;
//
//public class TransactionTester {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//Ű ����
//		
//		// 2. Ʈ����� ����, ����, ����
//		Transaction tx = new TokenTransaction(me, target, 1000, 1000);
//		
//		tx.Sign(privatekey);
//
//		if(tx.Validation(publickey)){
//			System.out.println("OK");	
//		}
//
//		byte[] sendBytes = tx.getBytes();
//
//		Transaction recvTransaction = new TokenTransaction(sendBytes);
//		
//		System.out.println(recvTransaction.getInput() - recvTransaction.getOutput());
//	}
//
//}
