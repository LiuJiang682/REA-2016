package au.com.rea.robot.command;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DirectionsTest {

	@Test
	public void shouldReturnNorthWhereLeftOfEast() {
		//Given
		Directions east = Directions.EAST;
		//When
		Directions north = east.getLeft();
		//Then
		assertEquals(Directions.NORTH, north);
	}
	
	@Test
	public void shouldReturnSouthWhereRightOfEast() {
		//Given
		Directions east = Directions.EAST;
		//When
		Directions south = east.getRight();
		//Then
		assertEquals(Directions.SOUTH, south);
	}
	
	@Test
	public void shouldReturnEastWhereLeftOfSouth() {
		//Given
		Directions south = Directions.SOUTH;
		//When
		Directions east = south.getLeft();
		//Then
		assertEquals(Directions.EAST, east);
	}
	
	@Test
	public void shouldReturnWestWhereRightOfSouth() {
		//Given
		Directions south = Directions.SOUTH;
		//When
		Directions west = south.getRight();
		//Then
		assertEquals(Directions.WEST, west);
	}
	
	@Test
	public void shouldReturnSouthWhereLeftOfWest() {
		//Given
		Directions west = Directions.WEST;
		//When
		Directions south = west.getLeft();
		//Then
		assertEquals(Directions.SOUTH, south);
	}
	
	@Test
	public void shouldReturnNorthWhereRightOfWest() {
		//Given
		Directions west = Directions.WEST;
		//When
		Directions north = west.getRight();
		//Then
		assertEquals(Directions.NORTH, north);
	}
	
	@Test
	public void shouldReturnWestWhereLeftOfNorth() {
		//Given
		Directions north = Directions.NORTH;
		//When
		Directions west = north.getLeft();
		//Then
		assertEquals(Directions.WEST, west);
	}
	
	@Test
	public void shouldReturnEastWhereRightOfNorth() {
		//Given
		Directions north = Directions.NORTH;
		//When
		Directions east = north.getRight();
		//Then
		assertEquals(Directions.EAST, east);
	}
}
