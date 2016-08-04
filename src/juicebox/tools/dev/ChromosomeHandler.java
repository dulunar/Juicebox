/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2011-2016 Broad Institute, Aiden Lab
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package juicebox.tools.dev;

import org.broad.igv.feature.Chromosome;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by muhammadsaadshamim on 8/3/16.
 */
public class ChromosomeHandler {
    Map<String, Chromosome> chromosomeMap = new HashMap<String, Chromosome>();
    List<String> chrIndices = new ArrayList<String>();

    public ChromosomeHandler(List<Chromosome> chromosomes) {
        for (Chromosome c : chromosomes) {
            chromosomeMap.put(c.getName().trim().toLowerCase().replaceAll("chr", ""), c);
            if (c.getName().equalsIgnoreCase("MT")) {
                chromosomeMap.put("m", c); // special case for mitochondria
            }
        }

        for (Chromosome chr : chromosomes) {
            chrIndices.add("" + chr.getIndex());
        }
    }

    public Chromosome getChr(String name) {
        return chromosomeMap.get(name.trim().toLowerCase().replaceAll("chr", ""));
    }

    public List<String> getChrIndices() {
        return chrIndices;
    }
}
