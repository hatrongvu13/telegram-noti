# Telegram notification
## Github Actions

```yaml
name: Build and Push Docker image to GitHub Container Registry

on:
  push:
    branches:
      - main  # Chạy workflow này khi có sự thay đổi trên nhánh chính (main)
  pull_request:
    branches:
      - main  # Chạy workflow khi có pull request vào nhánh chính

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v2

      - name: Set up Docker Buildx
        uses: docker/setup-buildx-action@v2

      - name: Log in to GitHub Container Registry
        uses: docker/login-action@v2
        with:
          registry: ghcr.io
          username: ${{ github.actor }}
          password: ${{ secrets.GIT_TOKEN }}  # Sử dụng GitHub token mặc định

      - name: Set up java JDK
        uses: actions/setup-java@v2
        with:
          java-version: '17'
          distribution: 'temurin'

      - name: Build with Maven
        run: mvn clean install -DskipTests=true

      - name: Build Docker image
        run: |
          docker build -t ghcr.io/${{ github.repository }}/telegram-noti:${{ github.sha }} .

      - name: Push Docker image to GitHub Container Registry
        run: |
          docker push ghcr.io/${{ github.repository }}/telegram-noti:${{ github.sha }}
```