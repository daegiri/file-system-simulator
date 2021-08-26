package cruzapi;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Inode
{
	public enum Type
	{
		FILE, DIR;
	}
	
	public static final int INODE_SIZE = 105;
	
	private final int index;
	private byte type;
	private final int[] pointer = new int[12];
	
	public Inode(int index)
	{
		this.index = index;
	}
	
	public int index()
	{
		return index;
	}
	
	public int[] pointer()
	{
		return pointer;
	}
	
	public boolean addPointer(int index)
	{
		for(int i = 0; i < pointer.length; i++)
		{
			if(pointer[i] == 0)
			{
				pointer[i] = index;
				return true;
			}
		}
		
		return false;
	}
//	
//	public void readName() throws IOException
//	{
//		Disk disk = Main.getDisk();
//		SuperBlock sb = disk.getSuperBlock();
//		
//		try(RandomAccessFile access = new RandomAccessFile(disk.getFile(), "rw");)
//		{
//			access.skipBytes(sb.getSize() + sb.getBlockBitmapSize() + (index - 1) * INODE_SIZE + 4);
//			
//			for(int i = 0; i < name.length; i++)
//			{
//				name[i] = access.readChar();
//			}
//		}
//		catch(IOException e)
//		{
//			throw e;
//		}
//	}
//	
//	public void readFully() throws IOException
//	{
//		Disk disk = Main.getDisk();
//		SuperBlock sb = disk.getSuperBlock();
//		
//		try(RandomAccessFile access = new RandomAccessFile(disk.getFile(), "rw");)
//		{
//			access.skipBytes(sb.getSize() + sb.getBlockBitmapSize() + (index - 1) * INODE_SIZE);
//			previous = access.readInt();
//			type = access.readByte();
//			
//			for(int i = 0; i < name.length; i++)
//			{
//				name[i] = access.readChar();
//			}
//			
//			for(int i = 0; i < pointer.length; i++)
//			{
//				pointer[i] = access.readInt();
//			}
//		}
//		catch(IOException e)
//		{
//			throw e;
//		}
//	}
//	
//	public void rw() throws IOException
//	{
//		Disk disk = Main.getDisk();
//		SuperBlock sb = disk.getSuperBlock();
//		
//		try(RandomAccessFile access = new RandomAccessFile(disk.getFile(), "rw");)
//		{
//			access.skipBytes(sb.getSize() + sb.getBlockBitmapSize() + (index - 1) * INODE_SIZE);
//			access.writeInt(previous);
////			access.writeByte(type);
//			access.writeChars(getName());
//			
//			for(int j : pointer)
//			{
//				access.writeInt(j);
//			}
//		}
//		catch(IOException e)
//		{
//			throw e;
//		}
//	}
//	
//	public String getBeautifulName()
//	{
//		return getName().trim();
//	}
//
//	@Override
//	public String toString()
//	{
//		return "Inode [index=" + index + ", previous=" + previous + ", name=" + getBeautifulName() + ", pointer="
//				+ Arrays.toString(pointer) + "]";
//	}
}