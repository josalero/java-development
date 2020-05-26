package com.josalero.articles.nullcheck.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class UserWithOptionalTest 
{

	@Test
	public void givenUserNameIsNull_whenCreatingAnInstance_thenThrowError()
	{
		assertThatThrownBy(() -> new UserWithOptional().setName(null)).isExactlyInstanceOf(NoDataProvidedException.class);
	}
	
	@Test
	public void givenUserNameIsNotNull_whenCreatingAnInstance_thenThrowErrorIsNotExpected()
	{
		UserWithOptional user = new UserWithOptional();
		user.setId(1L);
		user.setName("name");
		assertSame(user.getId(), 1L);
		assertSame(user.getName(), "name");
	}
}
