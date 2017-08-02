/* Copyright (c) 2016 Jesper Öqvist <jesper@llbit.se>
 *
 * Chunky is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Chunky is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Chunky.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.llbit.chunky.plugin;

import javafx.scene.control.Tab;
import se.llbit.chunky.Plugin;
import se.llbit.chunky.main.Chunky;
import se.llbit.chunky.main.ChunkyOptions;
import se.llbit.chunky.ui.ChunkyFx;
import se.llbit.chunky.ui.render.RenderControlsTab;
import se.llbit.chunky.ui.render.RenderControlsTabTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * This plugin adds a new Tab in the Render Controls dialog.
 */
public class TabMod implements Plugin {
  @Override public void attach(Chunky chunky) {
    RenderControlsTabTransformer prev = chunky.getRenderControlsTabTransformer();
    chunky.setRenderControlsTabTransformer(tabs -> {
      // First, call the previous transformer (this allows other plugins to work).
      List<RenderControlsTab> transformed = new ArrayList<>(prev.apply(tabs));

      // This adds a new tab after the first tab (the "General" tab):
      transformed.add(1, new CustomRenderTab());
      return transformed;
    });

    // Add a hook to insert a new tab in the main window.
    TabTransformer prevMainTabTransformer = chunky.getMainTabTransformer();
    chunky.setMainTabTransformer(tabs -> {
      // First, call the previous transformer (allowing other plugins to work).
      List<Tab> transformed = new ArrayList<>(prevMainTabTransformer.apply(tabs));

      // Add a new tab as the first tab:
      transformed.add(0, new CustomMainTab());
      return transformed;
    });
  }

  public static void main(String[] args) throws Exception {
    // Start Chunky normally with this plugin attached.
    Chunky.loadDefaultTextures();
    Chunky chunky = new Chunky(ChunkyOptions.getDefaults());
    new TabMod().attach(chunky);
    ChunkyFx.startChunkyUI(chunky);
  }
}
