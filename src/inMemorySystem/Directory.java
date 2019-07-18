package inMemorySystem;
import java.util.*;
public class Directory {
	public String name;
	public Map<String, Directory> subDirectories = new HashMap<>();
	public Map<String, File> files = new HashMap<>();
}
