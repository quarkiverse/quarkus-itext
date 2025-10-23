#!/usr/bin/env bash
# Sort Java imports alphabetically in all files recursively
# Works in Git Bash or WSL on Windows

find . -type f -name "*.java" | while read -r f; do
  echo "Sorting imports in: $f"

  awk '
    /^package / { print $0; print ""; next }
    /^import /  { imports[++i] = $0; next }
    { body[++b] = $0 }
    END {
      if (i > 0) {
        n = asorti(imports, sorted)
        for (j = 1; j <= n; j++) print imports[sorted[j]]
        print ""
      }
      for (j = 1; j <= b; j++) print body[j]
    }
  ' "$f" > "$f.tmp" && mv "$f.tmp" "$f"
done

