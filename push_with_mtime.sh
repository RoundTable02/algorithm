cd "/Users/tak/Desktop/DevFiles/algostudy"

# Git 초기화 (필요 시)
git init
git remote add origin https://github.com/RoundTable02/algorithm.git

# Git user 설정 (잔디 반영을 위해 이메일 맞춰주세요)
git config user.name "rountable02"
git config user.email "wontac02@gmail.com"  # ← GitHub에 등록된 이메일과 일치해야 잔디 반영됨

# 전체 파일을 수정 시간 기준으로 정렬
# 전체 파일을 순회하되, .gitignore에 의해 무시된 파일은 제외
find . -type f -not -path "./.git/*" | while read file; do
  # git check-ignore로 무시된 파일은 건너뜀
  if git check-ignore -q "$file"; then
    echo "무시된 파일이라 건너뜀: $file"
    continue
  fi

  # 파일 수정 날짜를 커밋 시간으로 설정
  commit_date=$(date -r "$file" "+%Y-%m-%dT%H:%M:%S")

  # Git add + 커밋
  git add "$file"
  GIT_AUTHOR_DATE="$commit_date" GIT_COMMITTER_DATE="$commit_date" git commit -m "Add $file (mtime: $commit_date)"
done

# 브랜치 설정 및 푸시
git branch -M main
git push -u origin main