package Framework;

public class Vec2
{
	float x;
	float y;
	// 
	public Vec2( float x_in,float y_in )
	{
		x = x_in;
		y = y_in;
	}
	
	public Vec2 Add( Vec2 other )
	{
		x += other.x;
		y += other.y;
		
		return this;
	}
	
	public Vec2 GetAdded( Vec2 other )
	{
		return( Clone().Add( other ) );
	}
	
	public Vec2 Subtract( Vec2 other )
	{
		x -= other.x;
		y -= other.y;
		
		return this;
	}
	
	public Vec2 GetSubtracted( Vec2 other )
	{
		return( Clone().Subtract( other ) );
	}
	
	public Vec2 Multiply( float amount )
	{
		x *= amount;
		y *= amount;
		
		return this;
	}
	
	public Vec2 GetMultiplied( float amount )
	{
		return( Clone().Multiply( amount ) );
	}
	
	public Vec2 Divide( float amount )
	{
		x /= amount;
		y /= amount;
		
		return this;
	}
	
	public Vec2 GetDivided( float amount )
	{
		return( Clone().Divide( amount ) );
	}
	
	public float GetLengthSq()
	{
		return( x * x + y * y );
	}
	
	public float GetLength()
	{
		return( ( float )Math.sqrt( GetLengthSq() ) );
	}
	
	public float GetAngle()
	{
		return( ( float )Math.atan2( ( double )y,( double )x ) );
	}
	
	public Vec2 Normalize()
	{
		float length = GetLength();
		if( length != 0.0f )
		{
			return( Multiply( 1.0f / length ) );
		}
		else
		{
			return( this );
		}
	}
	
	public Vec2 Clone()
	{
		return( new Vec2( x,y ) );
	}
}
