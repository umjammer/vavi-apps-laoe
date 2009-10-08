/*
 * This file is part of LAoE.
 * 
 * LAoE is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published
 * by the Free Software Foundation; either version 2 of the License,
 * or (at your option) any later version.
 * 
 * LAoE is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with LAoE; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package ch.laoe.ui;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import ch.laoe.clip.AClip;


/**
 * graphical component that represents a layered clip.
 * Only one layer is printed whithout alpha-information. This
 * component is used for thumbnail-representation of one layer.
 * 
 * @author olivier g�umann, neuch�tel (switzerland)
 * @target JDK 1.3
 * 
 * @version 17.08.00 erster Entwurf oli4
 */
public class GLayerViewer extends GClipPanel {
    /**
     * constructor
     */
    public GLayerViewer(AClip clip, int layerIndex) {
        super(clip);
        this.layerIndex = layerIndex;
    }

    protected int layerIndex;

    protected void paintFullClip(Graphics2D g2d) {
        Rectangle rect = new Rectangle(0, 0, getWidth(), getHeight());
        clipPlotter.paintLayerThumbnail(bgGraphics, rect, layerIndex);
    }
}
