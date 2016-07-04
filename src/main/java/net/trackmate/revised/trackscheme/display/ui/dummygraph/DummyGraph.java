package net.trackmate.revised.trackscheme.display.ui.dummygraph;

import java.util.HashSet;

import gnu.trove.map.hash.TIntObjectHashMap;
import net.trackmate.graph.GraphChangeListener;
import net.trackmate.graph.GraphIdBimap;
import net.trackmate.graph.GraphListener;
import net.trackmate.graph.ListenableGraph;
import net.trackmate.graph.object.AbstractObjectGraph;

public class DummyGraph extends AbstractObjectGraph< DummyVertex, DummyEdge > implements ListenableGraph< DummyVertex, DummyEdge >
{

	private class MyGraphIdBimap extends GraphIdBimap< DummyVertex, DummyEdge >
	{

		public MyGraphIdBimap()
		{
			super( null, null );
		}

		@Override
		public DummyEdge getEdge( final int id, final DummyEdge ref )
		{
			return idToEdgeMap.get( id );
		}

		@Override
		public int getEdgeId( final DummyEdge e )
		{
			return e.getId();
		}

		@Override
		public DummyVertex getVertex( final int id, final DummyVertex ref )
		{
			return idToVertexMap.get( id );
		}

		@Override
		public int getVertexId( final DummyVertex v )
		{
			return v.getId();
		}

	}

	private final GraphIdBimap< DummyVertex, DummyEdge > idmap;

	private final TIntObjectHashMap<DummyVertex> idToVertexMap;

	private final TIntObjectHashMap<DummyEdge> idToEdgeMap;

	public DummyGraph()
	{
		super( new Factory(), new HashSet<>(), new HashSet<>() );
		idmap = new MyGraphIdBimap();
		idToVertexMap = new TIntObjectHashMap<>();
		idToEdgeMap = new TIntObjectHashMap<>();
	}

	private static class Factory implements AbstractObjectGraph.Factory< DummyVertex, DummyEdge >
	{
		@Override
		public DummyVertex createVertex()
		{
			return new DummyVertex();
		}

		@Override
		public DummyEdge createEdge( final DummyVertex source, final DummyVertex target )
		{
			return new DummyEdge( source, target );
		}
	}

	public GraphIdBimap< DummyVertex, DummyEdge > getIdBimap()
	{
		return idmap;
	}

	@Override
	public DummyVertex addVertex()
	{
		final DummyVertex v = super.addVertex();
		idToVertexMap.put( v.getId(), v );
		return v;
	}

	@Override
	public DummyEdge addEdge( final DummyVertex source, final DummyVertex target )
	{
		final DummyEdge e = super.addEdge( source, target );
		idToEdgeMap.put( e.getId(), e );
		return e;
	}

	/*
	 * STATIC EXAMPLE
	 */

	public static DummyGraph example()
	{
		final DummyGraph graph = new DummyGraph();

		final DummyVertex AB = graph.addVertex().init( "AB", 0 );

		final DummyVertex ABa = graph.addVertex().init( "AB.a", 1 );
		final DummyVertex ABp = graph.addVertex().init( "AB.p", 1 );
		graph.addEdge( AB, ABa );
		graph.addEdge( AB, ABp );

		final DummyVertex ABal = graph.addVertex().init( "AB.al", 2 );
		final DummyVertex ABar = graph.addVertex().init( "AB.ar", 2 );
		graph.addEdge( ABa, ABal );
		graph.addEdge( ABa, ABar );

		final DummyVertex ABpl = graph.addVertex().init( "AB.pl", 2 );
		final DummyVertex ABpr = graph.addVertex().init( "AB.pr", 2 );
		graph.addEdge( ABp, ABpl );
		graph.addEdge( ABp, ABpr );

		final DummyVertex ABala = graph.addVertex().init( "AB.ala", 3 );
		final DummyVertex ABalp = graph.addVertex().init( "AB.alp", 3 );
		graph.addEdge( ABal, ABala );
		graph.addEdge( ABal, ABalp );

		final DummyVertex ABara = graph.addVertex().init( "AB.ara", 3 );
		final DummyVertex ABarp = graph.addVertex().init( "AB.arp", 3 );
		graph.addEdge( ABar, ABara );
		graph.addEdge( ABar, ABarp );

		final DummyVertex ABpla = graph.addVertex().init( "AB.pla", 3 );
		final DummyVertex ABplp = graph.addVertex().init( "AB.plp", 3 );
		graph.addEdge( ABpl, ABpla );
		graph.addEdge( ABpl, ABplp );

		final DummyVertex ABpra = graph.addVertex().init( "AB.pra", 3 );
		final DummyVertex ABprp = graph.addVertex().init( "AB.prp", 3 );
		graph.addEdge( ABpr, ABpra );
		graph.addEdge( ABpr, ABprp );

		final DummyVertex P1 = graph.addVertex().init( "P1", 0 );

		final DummyVertex P2 = graph.addVertex().init( "P2", 1 );
		final DummyVertex EMS = graph.addVertex().init( "EMS", 1 );
		graph.addEdge( P1, P2 );
		graph.addEdge( P1, EMS );

		final DummyVertex P3 = graph.addVertex().init( "P3", 2 );
		graph.addEdge( P2, P3 );
		final DummyVertex P4 = graph.addVertex().init( "P4", 3 );
		graph.addEdge( P3, P4 );
		final DummyVertex Z2 = graph.addVertex().init( "Z2", 4 );
		graph.addEdge( P4, Z2 );
		final DummyVertex Z2a = graph.addVertex().init( "Z2.a", 5 );
		graph.addEdge( Z2, Z2a );

		final DummyVertex E = graph.addVertex().init( "E", 3 );
		final DummyVertex MS = graph.addVertex().init( "MS", 3 );
		graph.addEdge( EMS, E );
		graph.addEdge( EMS, MS );

		return graph;

	}

	@Override
	public boolean addGraphListener( final GraphListener< DummyVertex, DummyEdge > listener )
	{
		return false;
	}

	@Override
	public boolean removeGraphListener( final GraphListener< DummyVertex, DummyEdge > listener )
	{
		return false;
	}

	@Override
	public boolean addGraphChangeListener( final GraphChangeListener listener )
	{
		return false;
	}

	@Override
	public boolean removeGraphChangeListener( final GraphChangeListener listener )
	{
		return false;
	}
}
