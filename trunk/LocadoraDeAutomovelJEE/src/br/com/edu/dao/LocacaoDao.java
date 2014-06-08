/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package br.com.edu.dao;

import java.sql.CallableStatement;

import br.com.edu.dto.*;
import br.com.edu.exceptions.*;

public interface LocacaoDao
{
	
	/** 
	 * Calculate the total value of rent 
	 * @throws FnCalculavtotalDaoException 
	 */
	public Locacao calculateTotalValue(Locacao dto) throws LocacaoDaoException, FnCalculavtotalDaoException;
	/** 
	 * Inserts a new row in the locacao table.
	 * @return 
	 */
	public boolean insert(Locacao dto) throws LocacaoDaoException;

	/** 
	 * Returns all rows from the locacao table that match the criteria ''.
	 */
	public Locacao[] findAll() throws LocacaoDaoException;

	/** 
	 * Returns all rows from the locacao table that match the criteria 'cod_automovel = :codAutomovel'.
	 */
	public Locacao[] findByAutomovel(int codAutomovel) throws LocacaoDaoException;

	/** 
	 * Returns all rows from the locacao table that match the criteria 'CPF_cliente = :cpfCliente'.
	 */
	public Locacao[] findByCliente(int cpfCliente) throws LocacaoDaoException;

	/** 
	 * Returns all rows from the locacao table that match the criteria 'cod_automovel = :codAutomovel'.
	 */
	public Locacao[] findWhereCodAutomovelEquals(int codAutomovel) throws LocacaoDaoException;

	/** 
	 * Returns all rows from the locacao table that match the criteria 'CPF_cliente = :cpfCliente'.
	 */
	public Locacao[] findWhereCpfClienteEquals(int cpfCliente) throws LocacaoDaoException;

	/** 
	 * Returns all rows from the locacao table that match the criteria 'dataLocacao = :dataLocacao'.
	 */
	public Locacao[] findWhereDataLocacaoEquals(String dataLocacao) throws LocacaoDaoException;

	/** 
	 * Returns all rows from the locacao table that match the criteria 'dataDevolucao = :dataDevolucao'.
	 */
	public Locacao[] findWhereDataDevolucaoEquals(String dataDevolucao) throws LocacaoDaoException;

	/** 
	 * Returns all rows from the locacao table that match the criteria 'valorTotal = :valorTotal'.
	 */
	public Locacao[] findWhereValorTotalEquals(float valorTotal) throws LocacaoDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the locacao table that match the specified arbitrary SQL statement
	 */
	public Locacao[] findByDynamicSelect(String sql, Object[] sqlParams) throws LocacaoDaoException;

	/** 
	 * Returns all rows from the locacao table that match the specified arbitrary SQL statement
	 */
	public Locacao[] findByDynamicWhere(String sql, Object[] sqlParams) throws LocacaoDaoException;

}