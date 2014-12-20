package cn.railsoft.util.db.mapping;

/**
 * VtablesId entity. @author MyEclipse Persistence Tools
 */

public class VtablesId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3202919469487151708L;
	private String tableName;
	private Long tableRows;

	// Constructors

	/** default constructor */
	public VtablesId() {
	}

	/** minimal constructor */
	public VtablesId(String tableName) {
		this.tableName = tableName;
	}

	/** full constructor */
	public VtablesId(String tableName, Long tableRows) {
		this.tableName = tableName;
		this.tableRows = tableRows;
	}

	// Property accessors

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Long getTableRows() {
		return this.tableRows;
	}

	public void setTableRows(Long tableRows) {
		this.tableRows = tableRows;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VtablesId))
			return false;
		VtablesId castOther = (VtablesId) other;

		return ((this.getTableName() == castOther.getTableName()) || (this
				.getTableName() != null && castOther.getTableName() != null && this
				.getTableName().equals(castOther.getTableName())))
				&& ((this.getTableRows() == castOther.getTableRows()) || (this
						.getTableRows() != null
						&& castOther.getTableRows() != null && this
						.getTableRows().equals(castOther.getTableRows())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTableName() == null ? 0 : this.getTableName().hashCode());
		result = 37 * result
				+ (getTableRows() == null ? 0 : this.getTableRows().hashCode());
		return result;
	}

}