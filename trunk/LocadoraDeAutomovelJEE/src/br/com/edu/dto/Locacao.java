/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package br.com.edu.dto;

import java.io.Serializable;
import java.util.*;

import br.com.edu.dao.*;
import br.com.edu.exceptions.*;
import br.com.edu.factory.*;

public class Locacao implements Serializable
{
	/** 
	 * This attribute maps to the column cod_automovel in the locacao table.
	 */
	protected int codAutomovel;

	/** 
	 * This attribute represents whether the primitive attribute codAutomovel is null.
	 */
	protected boolean codAutomovelNull = true;

	/** 
	 * This attribute maps to the column CPF_cliente in the locacao table.
	 */
	protected String cpfCliente;

	/** 
	 * This attribute represents whether the primitive attribute cpfCliente is null.
	 */
	protected boolean cpfClienteNull = true;

	/** 
	 * This attribute maps to the column dataLocacao in the locacao table.
	 */
	protected Date dataLocacao;

	/** 
	 * This attribute maps to the column dataDevolucao in the locacao table.
	 */
	protected Date dataDevolucao;

	/** 
	 * This attribute maps to the column valorTotal in the locacao table.
	 */
	protected float valorTotal;

	/** 
	 * This attribute represents whether the primitive attribute valorTotal is null.
	 */
	protected boolean valorTotalNull = true;

	/**
	 * Method 'Locacao'
	 * 
	 */
	public Locacao()
	{
	}

	/**
	 * Method 'getCodAutomovel'
	 * 
	 * @return int
	 */
	public int getCodAutomovel()
	{
		return codAutomovel;
	}

	/**
	 * Method 'setCodAutomovel'
	 * 
	 * @param codAutomovel
	 */
	public void setCodAutomovel(int codAutomovel)
	{
		this.codAutomovel = codAutomovel;
		this.codAutomovelNull = false;
	}

	/**
	 * Method 'setCodAutomovelNull'
	 * 
	 * @param value
	 */
	public void setCodAutomovelNull(boolean value)
	{
		this.codAutomovelNull = value;
	}

	/**
	 * Method 'isCodAutomovelNull'
	 * 
	 * @return boolean
	 */
	public boolean isCodAutomovelNull()
	{
		return codAutomovelNull;
	}

	/**
	 * Method 'getCpfCliente'
	 * 
	 * @return int
	 */
	public String getCpfCliente()
	{
		return cpfCliente;
	}

	/**
	 * Method 'setCpfCliente'
	 * 
	 * @param string
	 */
	public void setCpfCliente(String string)
	{
		this.cpfCliente = string;
		this.cpfClienteNull = false;
	}

	/**
	 * Method 'setCpfClienteNull'
	 * 
	 * @param value
	 */
	public void setCpfClienteNull(boolean value)
	{
		this.cpfClienteNull = value;
	}

	/**
	 * Method 'isCpfClienteNull'
	 * 
	 * @return boolean
	 */
	public boolean isCpfClienteNull()
	{
		return cpfClienteNull;
	}

	/**
	 * Method 'getDataLocacao'
	 * 
	 * @return String
	 */
	public Date getDataLocacao()
	{
		return dataLocacao;
	}

	/**
	 * Method 'setDataLocacao'
	 * 
	 * @param dataLocacao
	 */
	public void setDataLocacao(Date dataLocacao)
	{
		this.dataLocacao = dataLocacao;
	}

	/**
	 * Method 'getDataDevolucao'
	 * 
	 * @return String
	 */
	public Date getDataDevolucao()
	{
		return dataDevolucao;
	}

	/**
	 * Method 'setDataDevolucao'
	 * 
	 * @param dataDevolucao
	 */
	public void setDataDevolucao(Date dataDevolucao)
	{
		this.dataDevolucao = dataDevolucao;
	}

	/**
	 * Method 'getValorTotal'
	 * 
	 * @return float
	 */
	public float getValorTotal()
	{
		return valorTotal;
	}

	/**
	 * Method 'setValorTotal'
	 * 
	 * @param valorTotal
	 */
	public void setValorTotal(float valorTotal)
	{
		this.valorTotal = valorTotal;
		this.valorTotalNull = false;
	}

	/**
	 * Method 'setValorTotalNull'
	 * 
	 * @param value
	 */
	public void setValorTotalNull(boolean value)
	{
		this.valorTotalNull = value;
	}

	/**
	 * Method 'isValorTotalNull'
	 * 
	 * @return boolean
	 */
	public boolean isValorTotalNull()
	{
		return valorTotalNull;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof Locacao)) {
			return false;
		}
		
		final Locacao _cast = (Locacao) _other;
		if (codAutomovel != _cast.codAutomovel) {
			return false;
		}
		
		if (codAutomovelNull != _cast.codAutomovelNull) {
			return false;
		}
		
		if (cpfCliente != _cast.cpfCliente) {
			return false;
		}
		
		if (cpfClienteNull != _cast.cpfClienteNull) {
			return false;
		}
		
		if (dataLocacao == null ? _cast.dataLocacao != dataLocacao : !dataLocacao.equals( _cast.dataLocacao )) {
			return false;
		}
		
		if (dataDevolucao == null ? _cast.dataDevolucao != dataDevolucao : !dataDevolucao.equals( _cast.dataDevolucao )) {
			return false;
		}
		
		if (valorTotal != _cast.valorTotal) {
			return false;
		}
		
		if (valorTotalNull != _cast.valorTotalNull) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "locadora.colevati.av2.dto.Locacao: " );
		ret.append( "codAutomovel=" + codAutomovel );
		ret.append( ", cpfCliente=" + cpfCliente );
		ret.append( ", dataLocacao=" + dataLocacao );
		ret.append( ", dataDevolucao=" + dataDevolucao );
		ret.append( ", valorTotal=" + valorTotal );
		return ret.toString();
	}

}
