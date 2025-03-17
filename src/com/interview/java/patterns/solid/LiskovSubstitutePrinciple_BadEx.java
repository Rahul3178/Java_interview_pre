package com.interview.java.patterns.solid;

interface File{
	
	void read();
	void write();
	
}
class ReadOnly implements File{

	@Override
	public void read() {
		// TODO Auto-generated method stub
		System.out.println("Read only implemented");
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Write operation not supported");
	}
	
}

class WriteOnly implements File{

	@Override
	public void read() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Read not supported");
	}

	@Override
	public void write() {
		// TODO Auto-generated method stub
		
	}
	
}


// violation when parent supported Read + Write operation but child support read only thats is a clear violation on LSP -> to fix , divide large interface into smaller 
public class LiskovSubstitutePrinciple_BadEx {
	
	
	public static void main(String[] args) {
		File f= new ReadOnly();
		f.read();
		f.write();
	}
}
