package com.josalero.articles.nullcheck.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class UserWithPreconditionsTest 
{

	@Test
	public void givenUserNameIsNull_whenCreatingAnInstance_thenThrowError()
	{
		assertThatThrownBy(() -> new UserWithPreconditions().setName(null)).isExactlyInstanceOf(NullPointerException.class);
	}
	
	@Test
	public void givenUserNameIsNotNull_whenCreatingAnInstance_thenThrowErrorIsNotExpected()
	{
		UserWithPreconditions user = new UserWithPreconditions();
		user.setId(1L);
		user.setName("name");
		assertSame(user.getId(), 1L);
		assertSame(user.getName(), "name");
	}
}
