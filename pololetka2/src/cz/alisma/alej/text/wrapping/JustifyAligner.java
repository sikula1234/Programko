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
		width = w + 1;
	}
	
    @Override
    public String format(List<String> words) {
        StringBuilder result = new StringBuilder();
        int lineLength = 0;
        boolean justifyThis = true;
        
        // Count characters and spaces on a line
        for (String w : words) {
        	lineLength += w.length() + 1;
        }
        // Subtract the space afer the last word
        lineLength--;
        
        // Disable center-justifying if the text on the line is too short
        if (lineLength < (width / 2)) {
        	justifyThis = false;
        }
        
        // Calculate extra spaces per word
        double extraSpaces = width - lineLength;
        double extraSpacesPerWord = (extraSpaces + 1) / (words.size() - 1);
        
        // Add words and spaces inbetween them
        double spacesToBeAdded = 0;
        boolean first = true;
        for (String w : words) {
        	if (!first) {
                result.append(" ");
                
                // If it is time to add extra spaces, do it!
                spacesToBeAdded += extraSpacesPerWord;
                if (justifyThis) {
                	while (spacesToBeAdded > 1.00000001) {
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
