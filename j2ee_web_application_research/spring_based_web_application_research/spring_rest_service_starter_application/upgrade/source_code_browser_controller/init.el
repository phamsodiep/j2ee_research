(require 'server)
(setq server-use-tcp t server-socket-dir "~/.emacs.d/server")
(unless (server-running-p) (server-start))



(set 'source-code-browser-endpoint "http://localhost:8080/sourcecodebrowser/target")

(defun get-json-request-url (file-name file-position) (concat "{\"file\": \"" file-name "\", \"position\": " (number-to-string file-position) "}"))

(defun get-json-request-url-at-here () (get-json-request-url buffer-file-name (point)) )

(defun browse-source-code-at-here () (let ((url-request-method "POST") (url-request-extra-headers '(("Content-Type" . "application/json"))) (url-request-data (get-json-request-url-at-here))) (url-retrieve-synchronously source-code-browser-endpoint)))

(defun browse-source-code-at-here-cmd () (interactive) (browse-source-code-at-here) (message ""))

(global-set-key [?\M-\.] 'browse-source-code-at-here-cmd)
(global-set-key [?\M-\*] 'browse-source-code-at-here-cmd)
