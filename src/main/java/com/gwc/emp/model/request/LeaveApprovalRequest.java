package com.gwc.emp.model.request;

import java.util.List;

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
public class LeaveApprovalRequest 
{
	private int requestId;
	private int approverId;
	private String approvalStatus;
}
