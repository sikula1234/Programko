/*
 * MIT License
 * Copyright (c) 2017 Gymnazium Nad Aleji
 * Copyright (c) 2017 Vojtech Horky
 * Copyright (c) 2019 Jiri Heller
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cz.alisma.alej.text.wrapping;

import java.util.List;

/** Justify-aligns a line. */
public class JustifyAligner implements Aligner {
	
	int width;

	public JustifyAligner(int w) {
		width = w;
	}
	
    @Override
    public String format(List<String> words) {
        StringBuilder result = new StringBuilder();
        int lineLength = 0;
        double redundantSpaces = 0;
        double redundantSpacesPerWord = 0;
        double spacesToBeAdded = 0;
        double numberOfWords = words.size();
        boolean dontJustifyThis = false;
        
        for (String w : words) {
        	lineLength += w.length() + 1;
        }
        
        lineLength--;
        
        if (lineLength < (width / 2)) {
        	dontJustifyThis = true;
        }
        
        // System.out.printf("noW: %f\n", numberOfWords);
        redundantSpaces = width - lineLength + 1;
        // System.out.printf("rS: %f\n", redundantSpaces);
        redundantSpacesPerWord = (redundantSpaces + 1) / (numberOfWords - 1);
        // System.out.printf("rSpW: %f\n", redundantSpacesPerWord);
        
        boolean first = true;
        for (String w : words) {
        	if (!first) {
        		spacesToBeAdded += redundantSpacesPerWord;
            	// System.out.printf(" (%f) ", spacesToBeAdded);
                result.append(" ");
                if (!dontJustifyThis) {
                	while (spacesToBeAdded > 1.0000000001) {
                		result.append(" ");
                		spacesToBeAdded -= 1;
                	}
                }
            } else {
                first = false;
            }
            result.append(w);
        }
        
        return result.toString();
    }

}
