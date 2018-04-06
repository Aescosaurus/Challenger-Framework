package Framework;

public class Rect
{
	float x;
	float y;
	float width;
	float height;
	// 
	boolean Contains( Vec2 pos )
	{
		return ( pos.x > x && pos.x < x + width &&
			pos.y > y && pos.y < y + height );
	}
	
	boolean IsContainedBy( Rect other )
	{
		return ( x >= other.x && x + width <= other.x + other.width &&
				y >= other.y && y + height <= other.y + other.height );
	}
	
	boolean IsOverlappingWith( Rect other )
	{
		return ( other.x < x + width && other.x + other.width > x &&
				other.y < y + height && other.y + other.height > y );
	}
	
	void MoveTo( Vec2 pos )
	{
		x = pos.x;
		y = pos.y;
	}
}
