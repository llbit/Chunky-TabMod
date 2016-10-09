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

import se.llbit.chunky.Plugin;
import se.llbit.chunky.main.Chunky;
import se.llbit.chunky.main.ChunkyOptions;
import se.llbit.chunky.resources.TexturePackLoader;
import se.llbit.chunky.ui.ChunkyFx;
import se.llbit.chunky.ui.render.RenderControlsTab;
import se.llbit.chunky.ui.render.RenderControlsTabTransformer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * This plugin adds a new Tab in the Render Controls dialog.
 */
public class TabMod implements Plugin {
  @Override public void attach(Chunky chunky) {
    RenderControlsTabTransformer prev = chunky.getRenderControlsTabTransformer();
    chunky.setRenderControlsTabTransformer(tabs -> {
      List<RenderControlsTab> transformed = new ArrayList<>(prev.apply(tabs));
      // This adds a new tab after the first tab (the "General" tab):
      transformed.add(1, new CustomTab());
      return transformed;
    });
  }

  public static void main(String[] args)
      throws FileNotFoundException, TexturePackLoader.TextureLoadingError {
    // Start Chunky normally with this plugin attached.
    Chunky.loadDefaultTextures();
    Chunky chunky = new Chunky(ChunkyOptions.getDefaults());
    new TabMod().attach(chunky);
    ChunkyFx.startChunkyUI(chunky);
  }
}
