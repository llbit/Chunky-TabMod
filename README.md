Tab Plugin Template
===================

This is a template for inserting plugin tabs in Chunky.

Two types of tabs are demonstrated: main window tabs and render control tabs.

The class CustomMainTab demonstrates building a tab for the main Chunky window.
The main window tabs are simple, and are just a JavaFX Tab object.

The class CustomRenderTab demonstrates how to build a tab for the render
controls dialog.  This type of tab need to be updated when the scene
changes, so it implements the RenderControlsTab interface.
