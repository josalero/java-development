package com.josalero.articles.nullcheck.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class UserWithLombokTest 
{

	@Test
	public void givenUserNameIsNull_whenCreatingAnInstance_thenThrowError()
	{
		assertThatThrownBy(() -> new UserWithLombok(1L, null)).isExactlyInstanceOf(NullPointerException.class);
	}
	
	@Test
	public void givenUserNameIsNotNull_whenCreatingAnInstance_thenThrowErrorIsNotExpected()
	{
		UserWithLombok user = new UserWithLombok(1L, "name");
		assertSame(user.getId(), 1L);
		assertSame(user.getName(), "name");
	}
}
