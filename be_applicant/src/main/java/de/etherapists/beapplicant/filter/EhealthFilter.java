package de.etherapists.beapplicant.filter;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EhealthFilter implements javax.servlet.Filter {

    // private static final Logger logger = LoggerFactory.getLogger(EhealthFilter.class);

    private static final String LOCK = "LOCK";

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest origin = (HttpServletRequest) request;
        final HttpSession httpSession = origin.getSession(true);

        ReentrantLock lock = (ReentrantLock) httpSession.getAttribute(LOCK);
        if (lock == null) {
            synchronized (httpSession) {
                lock = new ReentrantLock();
                httpSession.setAttribute(LOCK, lock);
            }
        }

        lock.lock();
        // create session
        // logg er.info("check session...");

        try {
            chain.doFilter(request, response);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        // nothing to do
    }

}