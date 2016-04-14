package games.sokoban.sokoban1;

public interface ISokoban {

	public int CELL_STATIC_EMPTY = 0, CELL_STATIC_TARGET = 1, CELL_STATIC_WALL = 2;
	public int CELL_DYNAMIC_EMPTY = 0, CELL_DYNAMIC_PLAYER = 4, CELL_DYNAMIC_BOX = 8;
	
	/**
	 * @return The width of the grid
	 */
	public int getWidth();
	/**
	 * @return The height of the grid
	 */
	public int getHeight();
	
	/**
	 * Gets the static part of the cell, i.e. the part that never changes.
	 * @param x The x-coordinate of the cell
	 * @param y The y-coordinate of the cell
	 * @return The static content of a cell, either CELL_STATIC_EMPTY, CELL_STATIC_TARGET or CELL_STATIC_WALL
	 */
	public int getStaticCellValue(int x, int y);

	/**
	 * Gets the dynamic part of the cell, i.e. the movable part.
	 * @param x The x-coordinate of the cell
	 * @param y The y-coordinate of the cell
	 * @return The dynamic content of a cell, either CELL_DYNAMIC_EMPTY, CELL_DYNAMIC_PLAYER or CELL_DYNAMIC_BOX
	 */
	public int getDynamicCellValue(int x, int y);

	/**
	 * Count the number of cells matching a particular combination of static and dynamic cell value.
	 * @param cellStatic The static part to match, or null if it should be ignored when matching.
	 * @param cellDynamic The dynamic part to match, or null if it should be ignored when matching.
	 * @return The number of cells of a particular kind, i.e. matching cellStatic and cellDynamic
	 */
	public int countCells(Integer cellStatic, Integer cellDynamic);
	
	/**
	 * Initializes a game with a String representation of a level. All other game state should be cleared.
	 * @param level The level represented as a String, e.g. the standard representation
	 * with lines separated by newlines or vertical bars.
	 */
	public void init(String level);
	
	/**
	 * Moves the player in the indicated direction. Returns whether or not it was a push, or legal at all. 
	 * @param dx
	 * @param dy
	 * @return Returns TRUE if the move was a push, FALSE if it was a move or null of it was illegal. 
	 */
	public Boolean movePlayer(int dx, int dy);
}
