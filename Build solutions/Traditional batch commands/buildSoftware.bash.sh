#!/bin/bash
# 	宣告執行 script 程式用的殼程式(shell)的 shebang
################## Header block ##################
# Script程式名稱
# Script Name
#	軟體建構程式
# 	build software program
# 著作權宣告
# Copyright Declaration
# 	Ｖ字龍(Vdragon) <Vdragon.Taiwan@gmail.com> (c) 2014
# 授權條款宣告
# License Declaration
# 	〈你的軟體的授權條款(License of your software)〉
# 傳回值定義
# Return Value Definition
# 	0
# 		正常結束
# 已知問題
# Known Issues
# 	Known issues is now tracked on GitHub
# 	
# 修訂紀錄
# Changelog
# 	Changelog is now tracked using Git repostiory commit log
# 	
############## Header block ended ##############

######## Included files ########

######## Included files ended ########

######## File scope variable definitions ########
# idea from http://www.kfirlavi.com/blog/2012/11/14/defensive-bash-programming/
readonly PROGRAM_NAME="$(basename $0)"
readonly PROGRAM_DIRECTORY="$(readlink -m $(dirname $0))"
readonly PROGRAM_ARGUMENT_ORIGINAL_LIST="$@"
readonly PROGRAM_ARGUMENT_ORIGINAL_NUMBER=$#

project_global_directory="$(readlink -m "${PROGRAM_DIRECTORY}/../..")"

######## File scope variable definitions ended ########

######## Program ########
# main function, program entry point
# idea from http://www.kfirlavi.com/blog/2012/11/14/defensive-bash-programming/
main() {
	## 啟用除錯模式
	set -x

	find "${project_global_directory}/Source code" -name "*.java" -exec javac -d "Built software/" -sourcepath "${project_global_directory}/Source code" {} \;
	
	## 停用除錯模式
	set +x

	## 正常結束 script 程式
	exit 0
}
main
######## Program ended ########
