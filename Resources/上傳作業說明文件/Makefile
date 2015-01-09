.PHONY : all
all : unix2dos make_utf8_alternate

.PHONY : convert_big5
convert_big5 : 
	iconv --from-code UTF-8 --to-code BIG5 "上傳作業說明文件.UTF-8.md" --output "上傳作業說明文件.BIG5.md"

.PHONY : rename_txt
rename_txt : convert_big5
	mv "上傳作業說明文件.BIG5.md" "上傳作業說明文件.BIG5.md.txt"

.PHONY : unix2dos
unix2dos : rename_txt
	unix2dos "上傳作業說明文件.BIG5.md.txt"

.PHONY : make_utf8_alternate
make_utf8_alternate : 
	cp "上傳作業說明文件.UTF-8.md" "上傳作業說明文件.UTF-8.md.txt"
