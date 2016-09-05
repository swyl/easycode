package com.easycodebox.common.lang.dto;

import java.util.Date;

import com.easycodebox.common.jpa.MappedSuperclass;
import com.easycodebox.common.jpa.Temporal;
import com.easycodebox.common.jpa.TemporalType;
import com.easycodebox.common.jpa.Transient;

/**
 * @author WangXiaoJin
 * 
 */
@MappedSuperclass
public abstract class AbstractModifyEntity extends AbstractEntity implements ModifyEntity {

	private static final long serialVersionUID = 1850564296369846490L;

	private String modifier;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyTime;

	/********** 冗余字段  **************/
	@Transient
	private String modifierName;
	
	@Override
	public String getModifier() {
		return modifier;
	}

	@Override
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	@Override
	public Date getModifyTime() {
		return modifyTime;
	}

	@Override
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifierName() {
		return modifierName;
	}

	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}
	
}
