/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package br.com.edu.jdbc;

import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import br.com.edu.dao.*;
import br.com.edu.dto.*;
import br.com.edu.exceptions.*;
import br.com.edu.factory.*;

import com.sun.org.apache.bcel.internal.generic.FNEG;

public class LocacaoDaoImpl extends AbstractDAO implements LocacaoDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT cod_automovel, CPF_cliente, dataLocacao, dataDevolucao, valorTotal FROM " + getTableName() + "";
	
	/** 
	 * Calculate the total value of rent 
	 */
	protected final String SQL_fn_CalculaVTotal = "SELECT dbo.fn_CalculaVTotal(?, ?, ?, ?) ";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "{ call sp_Locacao ( ?, ?, ?, ?, ? ) }";

	/** 
	 * Index of column cod_automovel
	 */
	protected static final int COLUMN_COD_AUTOMOVEL = 1;

	/** 
	 * Index of column CPF_cliente
	 */
	protected static final int COLUMN_CPF_CLIENTE = 2;

	/** 
	 * Index of column dataLocacao
	 */
	protected static final int COLUMN_DATA_LOCACAO = 3;

	/** 
	 * Index of column dataDevolucao
	 */
	protected static final int COLUMN_DATA_DEVOLUCAO = 4;

	/** 
	 * Index of column valorTotal
	 */
	protected static final int COLUMN_VALOR_TOTAL = 5;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 5;

	/** 
	 * Inserts a new row in the locacao table.
	 */
	public boolean insert(Locacao dto) throws LocacaoDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		CallableStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareCall( SQL_INSERT );
			if (dto.isCodAutomovelNull()) {
				stmt.setNull( COLUMN_COD_AUTOMOVEL, java.sql.Types.INTEGER );
			} else {
				stmt.setInt( COLUMN_COD_AUTOMOVEL, dto.getCodAutomovel() );
			}
		
			if (dto.isCpfClienteNull()) {
				stmt.setNull( COLUMN_CPF_CLIENTE, java.sql.Types.INTEGER );
			} else {
				stmt.setString( COLUMN_CPF_CLIENTE, dto.getCpfCliente() );
			}
		
			stmt.setDate( COLUMN_DATA_LOCACAO, new java.sql.Date(dto.getDataLocacao().getTime()) );
			stmt.setDate( COLUMN_DATA_DEVOLUCAO, new java.sql.Date ( dto.getDataDevolucao().getTime()) );
			if (dto.isValorTotalNull()) {
				stmt.setNull( COLUMN_VALOR_TOTAL, java.sql.Types.FLOAT );
			} else {
				stmt.setFloat( COLUMN_VALOR_TOTAL, dto.getValorTotal() );
			}
		
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			stmt.execute();
			int rows = stmt.getUpdateCount();
			System.out.println( rows + " rows affected" );
			
			return true;
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new LocacaoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}
	
	public Locacao calculateTotalValue(Locacao dto) throws FnCalculavtotalDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		//CallableStatement stmt = null;
		ResultSet rs = null;
		
		try {
					
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
			
			// create a CallableStatement
			stmt = conn.prepareStatement( SQL_fn_CalculaVTotal );
				
			//stmt.registerOutParameter(1, Types.DATE);
			stmt.setInt( 1, dto.getCodAutomovel() );
			stmt.setString( 2, dto.getCpfCliente() );
			stmt.setDate( 3, dto.getDataLocacao()==null ? null : new java.sql.Date( dto.getDataLocacao().getTime() ) );
			stmt.setDate( 4, dto.getDataDevolucao()==null ? null : new java.sql.Date( dto.getDataDevolucao().getTime() ) );
								
			System.out.println( "Executing " + SQL_fn_CalculaVTotal + " with DTO: " + dto );			

		    
			stmt.executeQuery();
            rs = stmt.getResultSet();
            if(rs.next());                
            Object output=rs.getFloat(1);
            dto.setValorTotal((Float)output);    			    			
		
			return dto;
	
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new FnCalculavtotalDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}		
		
	}

	/** 
	 * Returns all rows from the locacao table that match the criteria ''.
	 */
	public Locacao[] findAll() throws LocacaoDaoException
	{
		return findByDynamicSelect( SQL_SELECT, null );
	}

	/** 
	 * Returns all rows from the locacao table that match the criteria 'cod_automovel = :codAutomovel'.
	 */
	public Locacao[] findByAutomovel(int codAutomovel) throws LocacaoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE cod_automovel = ?", new Object[] {  new Integer(codAutomovel) } );
	}

	/** 
	 * Returns all rows from the locacao table that match the criteria 'CPF_cliente = :cpfCliente'.
	 */
	public Locacao[] findByCliente(int cpfCliente) throws LocacaoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE CPF_cliente = ?", new Object[] {  new Integer(cpfCliente) } );
	}

	/** 
	 * Returns all rows from the locacao table that match the criteria 'cod_automovel = :codAutomovel'.
	 */
	public Locacao[] findWhereCodAutomovelEquals(int codAutomovel) throws LocacaoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE cod_automovel = ? ORDER BY cod_automovel", new Object[] {  new Integer(codAutomovel) } );
	}

	/** 
	 * Returns all rows from the locacao table that match the criteria 'CPF_cliente = :cpfCliente'.
	 */
	public Locacao[] findWhereCpfClienteEquals(int cpfCliente) throws LocacaoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE CPF_cliente = ? ORDER BY CPF_cliente", new Object[] {  new Integer(cpfCliente) } );
	}

	/** 
	 * Returns all rows from the locacao table that match the criteria 'dataLocacao = :dataLocacao'.
	 */
	public Locacao[] findWhereDataLocacaoEquals(String dataLocacao) throws LocacaoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE dataLocacao = ? ORDER BY dataLocacao", new Object[] { dataLocacao } );
	}

	/** 
	 * Returns all rows from the locacao table that match the criteria 'dataDevolucao = :dataDevolucao'.
	 */
	public Locacao[] findWhereDataDevolucaoEquals(String dataDevolucao) throws LocacaoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE dataDevolucao = ? ORDER BY dataDevolucao", new Object[] { dataDevolucao } );
	}

	/** 
	 * Returns all rows from the locacao table that match the criteria 'valorTotal = :valorTotal'.
	 */
	public Locacao[] findWhereValorTotalEquals(float valorTotal) throws LocacaoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE valorTotal = ? ORDER BY valorTotal", new Object[] {  new Float(valorTotal) } );
	}

	/**
	 * Method 'LocacaoDaoImpl'
	 * 
	 */
	public LocacaoDaoImpl()
	{
	}

	/**
	 * Method 'LocacaoDaoImpl'
	 * 
	 * @param userConn
	 */
	public LocacaoDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "aluguel..locacao";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Locacao fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Locacao dto = new Locacao();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Locacao[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Locacao dto = new Locacao();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Locacao ret[] = new Locacao[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Locacao dto, ResultSet rs) throws SQLException
	{
		dto.setCodAutomovel( rs.getInt( COLUMN_COD_AUTOMOVEL ) );
		if (rs.wasNull()) {
			dto.setCodAutomovelNull( true );
		}
		
		dto.setCpfCliente( rs.getString( COLUMN_CPF_CLIENTE ) );
		if (rs.wasNull()) {
			dto.setCpfClienteNull( true );
		}
		
		dto.setDataLocacao( rs.getDate( COLUMN_DATA_LOCACAO ) );
		dto.setDataDevolucao( rs.getDate( COLUMN_DATA_DEVOLUCAO ) );
		dto.setValorTotal( rs.getFloat( COLUMN_VALOR_TOTAL ) );
		if (rs.wasNull()) {
			dto.setValorTotalNull( true );
		}
		
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Locacao dto)
	{
	}

	/** 
	 * Returns all rows from the locacao table that match the specified arbitrary SQL statement
	 */
	public Locacao[] findByDynamicSelect(String sql, Object[] sqlParams) throws LocacaoDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new LocacaoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the locacao table that match the specified arbitrary SQL statement
	 */
	public Locacao[] findByDynamicWhere(String sql, Object[] sqlParams) throws LocacaoDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new LocacaoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}