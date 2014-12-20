package cn.railsoft.util.db.mapping;

/**
 * Vtables entity. @author MyEclipse Persistence Tools
 */

public class Vtables implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5328458146574107078L;
	private VtablesId id;

	// Constructors

	/** default constructor */
	public Vtables() {
	}

	/** full constructor */
	public Vtables(VtablesId id) {
		this.id = id;
	}

	// Property accessors

	public VtablesId getId() {
		return this.id;
	}

	public void setId(VtablesId id) {
		this.id = id;
	}

}