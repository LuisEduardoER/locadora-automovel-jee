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

public class Tipo implements Serializable
{
	/** 
	 * This attribute maps to the column codigo in the tipo table.
	 */
	protected int codigo;

	/** 
	 * This attribute maps to the column tipo in the tipo table.
	 */
	protected String tipo;

	/**
	 * Method 'Tipo'
	 * 
	 */
	public Tipo()
	{
	}

	/**
	 * Method 'getCodigo'
	 * 
	 * @return int
	 */
	public int getCodigo()
	{
		return codigo;
	}

	/**
	 * Method 'setCodigo'
	 * 
	 * @param codigo
	 */
	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	/**
	 * Method 'getTipo'
	 * 
	 * @return String
	 */
	public String getTipo()
	{
		return tipo;
	}

	/**
	 * Method 'setTipo'
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
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
		
		if (!(_other instanceof Tipo)) {
			return false;
		}
		
		final Tipo _cast = (Tipo) _other;
		if (codigo != _cast.codigo) {
			return false;
		}
		
		if (tipo == null ? _cast.tipo != tipo : !tipo.equals( _cast.tipo )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + codigo;
		if (tipo != null) {
			_hashCode = 29 * _hashCode + tipo.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return TipoPk
	 */
	public TipoPk createPk()
	{
		return new TipoPk(codigo);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "locadora.colevati.av2.dto.Tipo: " );
		ret.append( "codigo=" + codigo );
		ret.append( ", tipo=" + tipo );
		return ret.toString();
	}

}
