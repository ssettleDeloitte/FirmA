package FirmProjectPackage;

public class Environment {

	
	private int id = -1;
	private String name = "";
	private String url= "";
	
	public Environment() {
		super();
	}
	public Environment(String name, String url) {
		super();
		this.name = name;
		this.url = url;
	}
	public Environment(int id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}