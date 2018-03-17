package com.stanslab.excel.meta;

import java.util.List;

/**
 * 
 * @author Stalin
 *
 */
public class ExcelMeta {
	
	private RowMeta rowMeta;
	
	private List<ColumnMeta> columnMetas;
	
	public RowMeta getRowMeta() {
		return rowMeta;
	}

	public void setRowMeta(RowMeta rowMeta) {
		this.rowMeta = rowMeta;
	}
	
	public List<ColumnMeta> getColumnMetas() {
		return columnMetas;
	}

	public void setColumnMetas(List<ColumnMeta> columnMetas) {
		this.columnMetas = columnMetas;
	}

}
