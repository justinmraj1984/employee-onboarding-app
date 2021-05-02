package com.gwc.emp.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeleteRequest 
{
	private String entityName;
	private int entityId;
	private boolean activeFlag;
	private int submittedBy;
}
