cd "/Users/tak/Desktop/DevFiles/algostudy"

# Git user 설정 (잔디 반영을 위해 이메일 맞춰주세요)
git config user.name "rountable02"
git config user.email "wontac02@gmail.com"  # ← GitHub에 등록된 이메일과 일치해야 잔디 반영됨

# 전체 파일을 수정 시간 기준으로 정렬
find . -type f -not -path "./.git/*" | while read file; do
  # 파일의 mtime을 가져와서 포맷
  commit_date=$(date -r "$file" "+%Y-%m-%dT%H:%M:%S")

  # Git add + 커밋
  git add "$file"
  GIT_AUTHOR_DATE="$commit_date" GIT_COMMITTER_DATE="$commit_date" git commit -m "Add $file"
done

# 브랜치 설정 및 푸시
git branch -M main
git push -u origin main