//package transaction;
//
//public abstract class Transaction {
//	protected String tid = null;
//	protected long timestamp = 0L;		// transaction header ?
//	
//	private byte[] data = null;
//	pirvate byte[] signature = null;		// transaction body ?
//
//	public Transaction(){
//		this.timestamp = System.currentTimeMillis();
//		this.tid = sha256(data).toString().substring(0,32);
//	}
//
//	public Transaction(byte[] stream){
//		
//	}
//
//	public abstract byte[] transactionToBytes();
//
//	@Override
//	public byte[] getBytes(String privatekey){
//		return tid + timestamp + data + signature;
//	}
//
//	public byte[] Sign(String privatekey){
//		this.data = transactionToBytes();
//		this.signature = ?;
//		return this.signature;
//	}
//
//	public boolean Validation(String address? publickey?){
//		return this.signature ? address, publickey;
//	}
//}
