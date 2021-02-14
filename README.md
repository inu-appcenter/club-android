# club-android

[![GitHub Workflow Status](https://img.shields.io/github/workflow/status/inu-appcenter/club-android/Android%20CI)](https://github.com/inu-appcenter/club-android/actions?query=workflow%3A%22Android+CI%22)
[![GitHub last commit](https://img.shields.io/github/last-commit/inu-appcenter/club-android)](https://github.com/inu-appcenter/club-android/commits)
[![GitHub release (latest by date)](https://img.shields.io/github/v/release/inu-appcenter/club-android)](https://github.com/inu-appcenter/club-android/releases/latest)
[![GitHub stars](https://img.shields.io/github/stars/inu-appcenter/club-android?style=shield)](https://github.com/inu-appcenter/club-android/stargazers)
[![GitHub issues](https://img.shields.io/github/issues/inu-appcenter/club-android)](https://github.com/inu-appcenter/club-android/issues)
![GitHub closed issues](https://img.shields.io/github/issues-closed/inu-appcenter/club-android)
[![GitHub license](https://img.shields.io/github/license/inu-appcenter/club-android)](https://github.com/inu-appcenter/club-android/blob/master/LICENSE)

**동아리 Android 앱**

## 개요

교내 동아리 검색과 발견을 도와줍니다.

## 프로젝트 구조

이 프로젝트는 클린 아키텍쳐에서 영감을 받아 설계되었으며, 총 여섯 개의 모듈로 이루어져 있습니다:

> ### app
> Intrastructure 레이어에 해당합니다.
>
> 안드로이드 프리젠테이션 UI를 담당합니다. 액티비티와 프래그먼트, 뷰모델, 리소스와 위젯 등이 여기에 속합니다. `MVVM` 패턴을 적용하였습니다.

> ### domain
> Domain 레이어에 해당합니다.
>
> 엔티티, 유스케이스, 저장소 정의, 서비스 정의 등이 여기에 속합니다.

> ### data
> Interfaces/Infrastructure 레이어에 해당합니다.
>
> 저장소의 구현, Shared Preferences, Retrofit factory 등이 여기에 속합니다.

> ### common
> 모든 레이어에서 참조할 수 있는 유틸리티 모음입니다.
>
> `UseCase`, `Repository` 원형에 대한 정의와 안드로이드/비 안드로이드 유틸리티, 설정 오브젝트가 여기에 속합니다.

> ### base
> 자주 사용하는 기술 스택과 라이브러리, 익스텐션 등을 모아 둔 모듈입니다. common에 의해 프로젝트 전역에서 사용됩니다.
>
> Timber, Koin, Retrofit2, Navigation 등 필수 라이브러리와 유용한 익스텐션, 베이스 클래스, 유틸리티 등을 포함합니다.

> ### network
> 네트워크 상태 변경에 따른 이벤트를 받아볼 수 있도록 observer를 제공합니다.
>
> 이 프로젝트에 묶이지 않은 별도의 라이브러리입니다. base에 의해 사용됩니다.

## 업데이트 로그

는 아직 처음 버전 만드는 중이라 없습니다 ㅎㅎ

## 라이센스

소스 코드에는 GPLv3 라이센스가 적용됩니다. 라이센스는 [이곳](/LICENSE)에서 확인하실 수 있습니다.