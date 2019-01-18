//package test;
//
//import transaction.TokenTrasaction;
//import transaction.Transaction;
//
//public class TransactionTester {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//키 생성
//		
//		// 2. 트랜잭션 생성, 싸인, 검증
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
