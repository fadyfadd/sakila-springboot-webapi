package org.fadyfadd.sakilaspringbootwebapi;

public class CrudOperationStatusResponse {
	public OperationStatus getOperationStatus() {
		return operationStatus;
	}
	public void setOperationStatus(OperationStatus operationStatus) {
		this.operationStatus = operationStatus;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Integer getNbrOfImpactedRows() {
		return nbrOfImpactedRows;
	}
	public void setNbrOfImpactedRows(Integer nbrOfImpactedRows) {
		this.nbrOfImpactedRows = nbrOfImpactedRows;
	}
	public Object getExtraData() {
		return extraData;
	}
	public void setExtraData(Object extraData) {
		this.extraData = extraData;
	}
	
	OperationStatus operationStatus;
	String errorMessage;
	Integer nbrOfImpactedRows;
	Object extraData;	
}
