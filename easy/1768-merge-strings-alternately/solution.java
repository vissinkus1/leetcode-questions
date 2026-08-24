
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i++));
            }
            if (j < word2.length()) {
                sb.append(word2.charAt(j++));
            }
        }

        return sb.toString();
    }
}

