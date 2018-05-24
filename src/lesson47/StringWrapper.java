package lesson47;

public class StringWrapper {
	private String wrapped;
	
	public StringWrapper(String wrapped) {
		this.wrapped = wrapped;
	}

	public String substring(int beginIndex) {
		return "substring:" + wrapped.substring(beginIndex);
	}

	public String substring(int beginIndex, int endIndex) {
		return "substring:" + wrapped.substring(beginIndex, endIndex);
	}
}
