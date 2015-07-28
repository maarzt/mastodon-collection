package net.trackmate.trackscheme;

import java.awt.event.ActionEvent;

public class ActionBank
{
	/*
	 * EDIT MODEL.
	 */

	public static final AbstractNamedAction getDeleteSelectionAction( final ShowTrackScheme trackscheme )
	{
		return new AbstractNamedAction( "deleteSelection" )
		{
			private static final long serialVersionUID = 7237432299287538771L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				final SelectionModel< TrackSchemeVertex, TrackSchemeEdge > selectionModel = trackscheme.selectionModel;
				final TrackSchemeGraph graph = trackscheme.graph;
				for ( final TrackSchemeEdge e : selectionModel.getSelectedEdges() )
				{
					graph.remove( e );
				}
				for ( final TrackSchemeVertex v : selectionModel.getSelectedVertices() )
				{
					graph.remove( v );
				}
				selectionModel.clearSelection();
				trackscheme.layout.layoutX();
				trackscheme.order.build();
				trackscheme.repaint( true );
			}
		};
	}

	/*
	 * NAVIGATE WITH SELECTION.
	 */

	public static final AbstractNamedAction getNavigateToChildAction( final ShowTrackScheme trackscheme )
	{
		return new AbstractNamedAction( "navigateToChild" )
		{
			private static final long serialVersionUID = -8748889039516159858L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.selectionNavigator.child( true );
			}
		};
	}

	public static final AbstractNamedAction getNavigateToParentAction( final ShowTrackScheme trackscheme )
	{
		return new AbstractNamedAction( "navigateToParent" )
		{
			private static final long serialVersionUID = -819879165845995978L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.selectionNavigator.parent( true );
			}
		};
	}

	public static final AbstractNamedAction getNavigateToRightSibblingAction( final ShowTrackScheme trackscheme )
	{
		return new AbstractNamedAction( "navigateToRightSibbling" )
		{
			private static final long serialVersionUID = 4628178914912235537L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.selectionNavigator.rightSibbling( true );
			}
		};
	}

	public static final AbstractNamedAction getNavigateToLeftSibblingAction( final ShowTrackScheme trackscheme )
	{
		return new AbstractNamedAction( "navigateToLeftSibbling" )
		{
			private static final long serialVersionUID = -34234313547655566L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.selectionNavigator.leftSibbling( true );
			}
		};
	}

	public static final AbstractNamedAction getAddChildToSelectionAction( final ShowTrackScheme trackscheme )
	{
		return new AbstractNamedAction( "addChildToSelection" )
		{
			private static final long serialVersionUID = 2974983361072182473L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.selectionNavigator.child( false );
			}
		};
	}

	public static final AbstractNamedAction getAddParentToSelectionAction( final ShowTrackScheme trackscheme )
	{
		return new AbstractNamedAction( "addParentToSelection" )
		{
			private static final long serialVersionUID = -1699923865575611814L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.selectionNavigator.parent( false );
			}
		};
	}

	public static final AbstractNamedAction getAddRightSibblingToSelectionAction( final ShowTrackScheme trackscheme )
	{
		return new AbstractNamedAction( "addRightSibblingToSelection" )
		{
			private static final long serialVersionUID = -5851501792062577225L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.selectionNavigator.rightSibbling( false );
			}
		};
	}

	public static final AbstractNamedAction getAddLeftSibblingToSelectionAction( final ShowTrackScheme trackscheme )
	{
		return new AbstractNamedAction( "addLeftSibblingToSelection" )
		{
			private static final long serialVersionUID = 5740293861004609589L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.selectionNavigator.leftSibbling( false );
			}
		};
	}

	/*
	 * ZOOM.
	 */

	public static final AbstractNamedAction getZoomOutAction( final ShowTrackScheme trackscheme, final double zoomSpeed )
	{
		return new AbstractNamedAction( "zoomOut_" + zoomSpeed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.zoom( zoomSpeed );
			}
		};
	}

	public static final AbstractNamedAction getZoomInAction( final ShowTrackScheme trackscheme, final double zoomSpeed )
	{
		return new AbstractNamedAction( "zoomIn_" + zoomSpeed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.zoom( 1 / zoomSpeed );
			}
		};
	}

	public static final AbstractNamedAction getZoomOutXAction( final ShowTrackScheme trackscheme, final double zoomSpeed )
	{
		return new AbstractNamedAction( "zoomOutX_" + zoomSpeed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.zoomX( zoomSpeed );
			}
		};
	}

	public static final AbstractNamedAction getZoomInXAction( final ShowTrackScheme trackscheme, final double zoomSpeed )
	{
		return new AbstractNamedAction( "zoomInX_" + zoomSpeed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.zoomX( 1 / zoomSpeed );
			}
		};
	}

	public static final AbstractNamedAction getZoomOutYAction( final ShowTrackScheme trackscheme, final double zoomSpeed )
	{
		return new AbstractNamedAction( "zoomOutY_" + zoomSpeed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.zoomY( zoomSpeed );
			}
		};
	}

	public static final AbstractNamedAction getZoomInYAction( final ShowTrackScheme trackscheme, final double zoomSpeed )
	{
		return new AbstractNamedAction( "zoomInY_" + zoomSpeed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.zoomY( 1 / zoomSpeed );
			}
		};
	}

	/*
	 * MOVE.
	 */

	public static final AbstractNamedAction getMoveLeftAction( final ShowTrackScheme trackscheme, final double speed )
	{
		return new AbstractNamedAction( "moveLeft_" + speed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.moveBy( -speed, 0. );
			}
		};
	}

	public static final AbstractNamedAction getMoveUpLeftAction( final ShowTrackScheme trackscheme, final double speed )
	{
		return new AbstractNamedAction( "moveUpLeft_" + speed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.moveBy( -speed, -speed );
			}
		};
	}

	public static final AbstractNamedAction getMoveUpAction( final ShowTrackScheme trackscheme, final double speed )
	{
		return new AbstractNamedAction( "moveUp_" + speed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.moveBy( 0., -speed );
			}
		};
	}

	public static final AbstractNamedAction getMoveUpRightAction( final ShowTrackScheme trackscheme, final double speed )
	{
		return new AbstractNamedAction( "moveUpRight_" + speed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.moveBy( speed, -speed );
			}
		};
	}

	public static final AbstractNamedAction getMoveRightAction( final ShowTrackScheme trackscheme, final double speed )
	{
		return new AbstractNamedAction( "moveRight_" + speed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.moveBy( speed, 0. );
			}
		};
	}

	public static final AbstractNamedAction getMoveDownRightAction( final ShowTrackScheme trackscheme, final double speed )
	{
		return new AbstractNamedAction( "moveDownRight_" + speed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.moveBy( speed, speed );
			}
		};
	}

	public static final AbstractNamedAction getMoveDownAction( final ShowTrackScheme trackscheme, final double speed )
	{
		return new AbstractNamedAction( "moveDown_" + speed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.moveBy( 0., speed );
			}
		};
	}

	public static final AbstractNamedAction getMoveDownLeftAction( final ShowTrackScheme trackscheme, final double speed )
	{
		return new AbstractNamedAction( "moveDownLeft_" + speed )
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed( final ActionEvent event )
			{
				trackscheme.transformHandler.moveBy( -speed, speed );
			}
		};
	}

	private ActionBank()
	{}
}
