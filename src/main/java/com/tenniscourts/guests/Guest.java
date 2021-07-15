package com.tenniscourts.guests;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.tenniscourts.config.persistence.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
public class Guest extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	@NotNull
	private String name;

}