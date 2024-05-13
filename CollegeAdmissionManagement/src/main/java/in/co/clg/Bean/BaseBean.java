package in.co.clg.Bean;

import java.io.Serializable;

public abstract class BaseBean implements Serializable ,DropDownListBean, Comparable<BaseBean>{

	protected long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public int compareTo(BaseBean next) {
	    return getValue().compareTo(next.getValue());
			// return getValue().compareTo(next.getValue());
	    }
	

}
