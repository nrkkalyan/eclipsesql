package net.sourceforge.sqlexplorer.db2.nodes;

import net.sourceforge.sqlexplorer.Messages;
import net.sourceforge.sqlexplorer.dbstructure.nodes.AbstractSQLFolderNode;

/**
 * Database Structure Node for Functions.
 * 
 * @modified Davy Vanherbergen
 */
public class FunctionFolder extends AbstractSQLFolderNode {

	public FunctionFolder() {
		super(Messages.getString("db2.dbstructure.functions"));
	}

	/**
	 * @see net.sourceforge.sqlexplorer.dbstructure.nodes.AbstractSQLFolderNode#getChildType()
	 */
	public String getChildType() {
		return "function";
	}

    /**
     * @see net.sourceforge.sqlexplorer.dbstructure.nodes.AbstractSQLFolderNode#getSQL()
     */
	public String getSQL() {
		String sql = "select rtrim(routinename) from syscat.routines a where routineschema = ? and routinetype='F'";
		return sql;
	}

    /**
     * @see net.sourceforge.sqlexplorer.dbstructure.nodes.AbstractSQLFolderNode#getSQLParameters()
     */
	public Object[] getSQLParameters() {
		return new Object[] {getSchemaOrCatalogName()};
	}
}
